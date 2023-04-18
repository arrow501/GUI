import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Slowa implements Iterable<Entry<String,Integer>>{
    Charset charset = StandardCharsets.UTF_8;

    Map<String,Integer> wordCount;
    public Slowa(String filePath) {
        try{
            wordCount = Files.lines(Paths.get(filePath)) // linm
                    .flatMap(line -> Stream.of(line.split("\\s+")))  // substrings
                    .map(s -> s.replaceAll("[^\\p{L}\\s]+", ""))    // words
                    .filter(s -> s != null && !s.isEmpty() )        // non-empty
                    .collect(Collectors.toMap(String::toUpperCase, word -> 1, Integer::sum));
        } catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Iterator<Entry<String, Integer>> iterator() {
        // TODO Auto-generated method stub
        return wordCount.entrySet().iterator();
    }
}
