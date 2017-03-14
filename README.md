# lejos-nxt

<h2>Why does these files look like they have been written by someone who just started to learn programming?</h2>

I agree. These are just some very basic java files that defines a behaviour of the lego nxt robot. It's a very simple robot that follows a wall of its based on <a href="https://en.wikipedia.org/wiki/Subsumption_architecture">subsumption architecture </a>. This was done for studying and research purpose the architect and had nothing to do with writing fancy codes.

Watch its behaviour here: <br>
https://www.youtube.com/watch?v=1VUQs2IHqHQ
<br>

<h2>What is it doing? Brief explanation</h2>

It tries to follow the wall on its left. In a normal situation, it will continue walking in a straight as long as there is a wall on the left. If it detects there is no wall or enough space to turn left, then it will do a simple 90 degree turn left and continue again. It also attempts to align with the wall as you can see in some section of the video so that it is more accurate on the path. However it it bumps straight to a wall ahead, then it does 90 degree turn **right** since at this point, we know we can go left. And that is pretty much what it does.

<h2>How does it work</h2>

There are just two sensors for this - ultrasonic sensor on the left and physical bumper sensor on the front. Initially we used a light sensor instead of ultra sonic since it was quite small and easy to fit however started to become problematic due to need to calibrate the light and different behaviours occurred on different lighting conditions. Light sensor could have been a better solution if it was to follow some trails on the ground however it was not the primary objective. But in any case, that was also part of the study to understand what works best on what scenarios and aims. So we used ultrasonic sensor to detect the length of the wall of the left and try to keep an adequate gap not less the length of the robot. Ultrasonic was best (out of all the limited sensor we had in the box) for this behaviour objective since the lightning condition did not really affect the measurements.

The (very simple) java based api for lejox can be found here:<br>
http://www.lejos.org/nxt/nxj/api/
