package com.ibm.hdm.server;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	
	public static void setup() throws IOException{
		URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(1234).build();
	    ResourceConfig config = new ResourceConfig(HelloWorld.class);
	    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
	    server.start();
	}

	public static void main(String[] args) {
		System.out.println("hello world!");
		try {
			setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
