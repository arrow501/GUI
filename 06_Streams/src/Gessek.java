import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Gessek implements Iterable<Entry<String, Integer>> {
    Charset charset = StandardCharsets.UTF_8;
    String file;
    Map<String, Integer> map = new HashMap<>();

    public Gessek(String file) {
        this.file = file;
        try {
            Files.lines(Paths.get(file), charset)
                    .flatMap(line -> Stream.of(line.split("\\s")))
                    .forEach(s -> {
                        s = s.replaceAll("[^\\p{L}]+", "").strip().toUpperCase();
                        if (!s.isEmpty()) {
                            if (!map.containsKey(s))
                                map.put(s, 1);
                            else
                                map.put(s, map.get(s) + 1);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Iterator<Entry<String, Integer>> iterator() {
        return map.entrySet().iterator();
    }

    @Override
    public Spliterator<Entry<String, Integer>> spliterator() {
        return map.entrySet().spliterator();
    }

    @Override
    public void forEach(Consumer<? super Entry<String, Integer>> action) {
        map.entrySet().forEach(action);
    }
}
