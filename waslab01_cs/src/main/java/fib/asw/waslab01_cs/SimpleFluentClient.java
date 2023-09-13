package fib.asw.waslab01_cs;

import org.apache.hc.client5.http.fluent.Request;

//This code uses the Fluent API

public class SimpleFluentClient {

	private static String URI = "http://localhost:8080/waslab01_ss/";

	public final static void main(String[] args) throws Exception {
  	
  	/* Insert code for Task #4 here */
		String idTwt = Request.Post(URI + "wot")
				.bodyForm(Form.form().add("author",  "Andreu").add("tweet_text",  "hola bon dia").build())
				.addHeader("Accept", "text/plain").execute().returnContent().asString();
		System.out.println(idTwt);

  		System.out.println(Request.get(URI).execute().returnContent());
  	
  	/* Insert code for Task #5 here */
		System.out.println(String.format("El tweet #%s ha sigut esborrat", Integer.parseInt(idTwt)-1));
		Request.Post(URI + "wot").addHeader("Accept", "text/plain").bodyForm(Form.form().add("twid", idTwt).build()).execute();
  }
}