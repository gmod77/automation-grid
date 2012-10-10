package com.saucelabs.saucerest;

import org.json.simple.JSONValue;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple Java API that invokes the Sauce REST API.
 */
public class SauceREST {
    protected String username;
    protected String accessKey;

    public static final String RESTURL = "http://saucelabs.com/rest/v1/%1$s";
    private static final String USER_RESULT_FORMAT = RESTURL + "/%2$s";
    private static final String JOB_RESULT_FORMAT = RESTURL + "/jobs/%2$s";
    private static final String DOWNLOAD_VIDEO_FORMAT = JOB_RESULT_FORMAT + "/results/video.flv";
    private static final String DOWNLOAD_LOG_FORMAT = JOB_RESULT_FORMAT + "/results/video.flv";
    private static final String DATE_FORMAT = "yyyyMMdd_HHmmSS";

    public SauceREST(String username, String accessKey) {
        this.username = username;
        this.accessKey = accessKey;
    }

    /**
     * Marks a Sauce Job as 'passed'.
     *
     * @param jobId the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
     * @throws IOException thrown if an error occurs invoking the REST request
     */
    public void jobPassed(String jobId) throws IOException {
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", true);
        updateJobInfo(jobId, updates);
    }

    /**
     * Marks a Sauce Job as 'failed'.
     *
     * @param jobId the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
     * @throws IOException thrown if an error occurs invoking the REST request
     */
    public void jobFailed(String jobId) throws IOException {
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", false);
        updateJobInfo(jobId, updates);
    }

    /**
     * Downloads the video for a Sauce Job to the filesystem.  The file will be stored in
     * a directory specified by the <code>location</code> field.
     *
     * @param jobId    the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
     * @param location
     * @throws IOException thrown if an error occurs invoking the REST request
     */
    public void downloadVideo(String jobId, String location) throws IOException {
        URL restEndpoint = new URL(String.format(DOWNLOAD_VIDEO_FORMAT, username, jobId));
        downloadFile(jobId, location, restEndpoint);
    }

    /**
     * Downloads the log file for a Sauce Job to the filesystem.  The file will be stored in
     * a directory specified by the <code>location</code> field.
     *
     * @param jobId    the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
     * @param location
     * @throws IOException thrown if an error occurs invoking the REST request
     */
    public void downloadLog(String jobId, String location) throws IOException {
        URL restEndpoint = new URL(String.format(DOWNLOAD_LOG_FORMAT, username, jobId));
        downloadFile(jobId, location, restEndpoint);
    }

    public String retrieveResults(String path) throws IOException {
        URL restEndpoint = new URL(String.format(USER_RESULT_FORMAT, username, path));
        return retrieveResults(restEndpoint);
    }

    public String getJobInfo(String jobId) throws IOException {
        URL restEndpoint = new URL(String.format(JOB_RESULT_FORMAT, username, jobId));
        return retrieveResults(restEndpoint);
    }

    public String retrieveResults(URL restEndpoint) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) restEndpoint.openConnection();
        connection.setDoOutput(true);
        String auth = encodeAuthentication();
        connection.setRequestProperty("Authorization", auth);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            builder.append(inputLine);
        }
        reader.close();
        return builder.toString();
    }

    private void downloadFile(String jobId, String location, URL restEndpoint) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) restEndpoint.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        String auth = encodeAuthentication();
        connection.setRequestProperty("Authorization", auth);

        InputStream stream = connection.getInputStream();
        BufferedInputStream in = new BufferedInputStream(stream);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        String saveName = jobId + format.format(new Date());
        if (restEndpoint.getPath().endsWith(".flv")) {
            saveName = saveName + ".flv";
        } else {
            saveName = saveName + ".log";
        }
        FileOutputStream file = new FileOutputStream(new File(location, saveName));
        BufferedOutputStream out = new BufferedOutputStream(file);
        int i;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
        out.flush();
    }

    public void updateJobInfo(String jobId, Map<String, Object> updates) throws IOException {
        URL restEndpoint = new URL(String.format(JOB_RESULT_FORMAT, username, jobId));
        HttpURLConnection postBack = (HttpURLConnection) restEndpoint.openConnection();
        postBack.setDoOutput(true);
        postBack.setRequestMethod("PUT");
        String auth = encodeAuthentication();
        postBack.setRequestProperty("Authorization", auth);
        String jsonText = JSONValue.toJSONString(updates);
        postBack.getOutputStream().write(jsonText.getBytes());
        postBack.getInputStream().close();
    }

    private String encodeAuthentication() {
        String auth = username + ":" + accessKey;
        //Handle long strings encoded using BASE64Encoder - see http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6947917
        BASE64Encoder encoder = new BASE64Encoder() {
            @Override
            protected int bytesPerLine() {
                return 9999;
            }
        };
        auth = "Basic " + new String(encoder.encode(auth.getBytes()));
        return auth;
    }
}
