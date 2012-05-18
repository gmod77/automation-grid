//package org.urbandaddy.helpers;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import ch.ethz.ssh2.Connection;
//import ch.ethz.ssh2.Session;
//import ch.ethz.ssh2.StreamGobbler;
//
//public class SSHHelper
//{
//	public static void reindexSolr(String[] args)
//	{
//		String hostname = "puppet.qa.urbandaddy.com";
//		String username = "gene";
//
//		File keyfile = new File("/Users/gene/.ssh/id_rsa"); // or "~/.ssh/id_dsa"
//		String keyfilePass = "common"; // will be ignored if not needed
//
//		try
//		{
//			/* Create a connection instance */
//
//			Connection conn = new Connection(hostname);
//
//			/* Now connect */
//
//			conn.connect();
//
//			/* Authenticate */
//
//			boolean isAuthenticated = conn.authenticateWithPublicKey(username, keyfile, keyfilePass);
//
//			if (isAuthenticated == false)
//				throw new IOException("Authentication failed.");
//
//			/* Create a session */
//
//			Session sess = conn.openSession();
//
//			//sess.execCommand("uname -a && date && uptime && who");
//			
//			sess.execCommand("fab -f /srv/fabric/fabfile.py solr_lite_reindex");
//			//sess.execCommand("fab solr_lite_reindex");
//			
//			InputStream stdout = new StreamGobbler(sess.getStdout());
//
//			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
//
//			System.out.println("Started Reindexing Solr");
//
//			while (true)
//			{
//				String line = br.readLine();
//				if (line == null)
//					break;
//				System.out.println(line);
//			}
//
//			/* Close this session */
//			
//			sess.close();
//
//			/* Close the connection */
//
//			conn.close();
//
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace(System.err);
//			System.exit(2);
//		}
//	}
//}
