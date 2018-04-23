package eu.rtakacs.watch;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchServiceTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Path path = Paths.get("/temp").toAbsolutePath();
		System.out.println(path);
		WatchService watchService = path.getFileSystem().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
		
		WatchKey watchKey = null;
		boolean valid = true;
		while(true) {
			watchKey = watchService.take();	//blocking operation
//			watchKey = watchService.poll(1, TimeUnit.MINUTES); // non-blocking operation, waiting the necessaty time
//			watchKey = watchService.poll(); //non-blocking operation
			
			/*
			watchKey state:
			1. ready 			- initially created 
			2. signalled		- event is detected
			3. watchKey.reset() -> ready state
			
			*/
			
			if(watchKey != null) {
				System.out.println("watchKey.isValid() = " +  watchKey.isValid());
				watchKey.pollEvents().stream().forEach(event -> System.out.println(event.kind() + " "  + event.context() + " " + event.count()));
				System.out.println("watchKey.isValid() = " +  watchKey.isValid());
				valid = watchKey.reset();
				if(!valid){
					System.out.println("Watch directory /temp ended. The /temp direcoty no longer exists.");
					break;
				}
			}
		}
	}
}
