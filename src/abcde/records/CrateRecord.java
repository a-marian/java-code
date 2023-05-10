package abcde.records;

public record CrateRecord<T> (T contents) {

    public T contents(){
        if (contents == null)
            throw new IllegalArgumentException("mising contents");
        return contents;
    }
}
