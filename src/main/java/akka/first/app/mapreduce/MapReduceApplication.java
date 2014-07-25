package akka.first.app.mapreduce;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.first.app.mapreduce.actors.MasterActor;
import akka.first.app.mapreduce.messages.Result;

public class MapReduceApplication {

	public static void main(String[] args) throws Exception {

		ActorSystem _system = ActorSystem.create("MapReduceApp");
		
		ActorRef master = _system.actorOf(new Props(MasterActor.class),"master");
		
		master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog");
		master.tell("Dog is man's best friend");
		master.tell("Dog and Fox belong to the same family");
		
		Thread.sleep(500);
		
		master.tell(new Result(), null);
		
		Thread.sleep(500);
		
		_system.shutdown();
        System.out.println("Java done!");
	}
}
