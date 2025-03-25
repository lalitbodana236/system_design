package com.lalitbodana.lld.behavioral.observerdesignpattern.youtubechannel;

public class Main {
    public static void main(String[] args) {

        // Created new users;
        User jhon = new User("Jhon");
        User mari = new User("Mari");
        User jim = new User("Jim");

        // Created the channels
        Channel music = new Music();
        Channel educational = new Educational();

        // jhon subscribe the music; mari and jim subscribe the educational channel.
        // They will get the notification as a subscription channel
        music.addObserver(jhon);
        educational.addObserver(mari);
        educational.addObserver(jim);

        music.uploadVideo();
        // Output:
        // Uploaded new music video
        // Hello Jhon, please check the new video

        educational.uploadVideo();
        // Output:
        // Uploaded new educational video
        // Hello Mari, please check the new video
        // Hello Jim, please check the new video

    }
}
