package features;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GraphConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(
            Network.class,
            (DataTable raw) -> {
                final Network network = new Network();
                List<List<String>> lines = raw.asLists();
                List<String> head = head(lines);
                List<String> columnTitles = tail(head);
                System.out.println("cols :");
                columnTitles.forEach(System.out::println);
                List<String> lineTitles = tail(lines).stream().map(l->l.get(0)).collect(Collectors.toList());
                System.out.println("lines :");
                lineTitles.forEach(System.out::println);
                for (int i = 0; i < columnTitles.size(); i++) {
                    for (int j = 0; j < lineTitles.size()-(i+1); j++) {
                        List<String> line = lines.get(i + 1);
                        String s = line.get(j + 1);
                        if(s.equals("x")){
                            String cityA = columnTitles.get(j);
                            String cityB = lineTitles.get(i);


                        }
                    }
                }
                return network;
            }
        ));
    }

    private <T> T head(List<T> l) {
        return l.get(0);
    }
    private <T> List<T> tail(List<T> l) {
        return new ArrayList<>(l).subList(1,l.size());
    }
}
