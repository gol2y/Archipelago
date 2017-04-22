package th.co.scb.quest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Question2 {

	public static void main(String[] args) throws Exception {
		Path commandPath = Paths.get(ClassLoader.getSystemResource("command.txt").toURI());
		Archipelago archipelago = new Archipelago();
		try (Stream<String> commands = Files.lines(commandPath)){
			int day = 0;
			for(String strCommand : commands.toArray(String[]::new)){
				String result = archipelago.order(day++, strCommand);
				if(result.length() > 0)
					System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
