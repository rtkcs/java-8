package eu.rtakacs.watch;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchKeyWithoutReset {

	public static void main(String[] args) {
		
		Path path = Paths.get("c:/temp");
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WatchKey watchKey = null;
		
		while(true) {

			try {
				watchKey = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("key.isValid() = " + watchKey.isValid());

			for(WatchEvent<?> watchEvent : watchKey.pollEvents()) {
				Kind<?> kind = watchEvent.kind();
				
				System.out.println("kind = " + kind);
				System.out.println("watchEvent.kind.name = " + kind.name() + "  watchEvent.kind.type = " + kind.type());
				System.out.println("watchEvent.context = " + watchEvent.context());
				if(watchEvent.context()!=null && watchEvent.context() instanceof Path) {
					Path eventPath = (Path)watchEvent.context();
					System.out.println("eventPath = " + eventPath.toAbsolutePath());
				}
			}

			System.out.println("key.isValid() = " + watchKey.isValid());
		}
	}
}
