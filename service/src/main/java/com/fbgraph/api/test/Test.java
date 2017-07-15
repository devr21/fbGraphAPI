package com.fbgraph.api.test;

import static java.lang.System.out;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.FriendList;
import com.restfb.types.Page;
import com.restfb.types.User;

public class Test {

	private static final String ACCESS_TOKEN = "EAACEdEose0cBAF3Bnn0JZAV89v5orLF7PZBSDBRdoN1ZC8HvbZC0ywe7Rcvj065TgbimVHzOJrJoHUo4WiIUAGpV5Rs4nOHYECnpbfZCnH4ZA4UGl8jbx8DZAcu0ULN4AcQsdu2UOZB6gOhxxUM14mh3LFY7CfQJRYWZCy1QG14bCyenZACZBZBWtWZAgoFCzvc22DG4ZD";
	private final FacebookClient fbClient;
	public static void main(String []args){
		
	 	new Test().start();
		
		
	}
	
	Test(){
		fbClient = new DefaultFacebookClient(ACCESS_TOKEN,Version.VERSION_2_9);
	}
	
	private void start(){
		out.println("* Fetching Objects *");
		
		User user = fbClient.fetchObject("me", User.class);
		out.println("User name: "+user.getName());
		 getFriends(user);

	}

	private void getFriends(User user) {
		out.println("* Fetching Friends");
		Connection<User> myFriends = fbClient.fetchConnection("me/friends", User.class);
		
		out.println(myFriends);
	}
	
}
