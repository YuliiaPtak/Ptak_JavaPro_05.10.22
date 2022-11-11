import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> files = new HashMap<>();

    public void add(String path, FileData fileData) {
        if (!fileData.getPath().equals(path)) {
            throw new IllegalArgumentException("Path " + path + " does not equals fileData path: " + fileData.getPath());
        }

        if (files.containsKey(path)) {
            files.get(path).add(fileData);
        } else {
            List<FileData> newList = new ArrayList<>();
            newList.add(fileData);
            files.put(path, newList);
        }
    }

    public List<FileData> find(String path) {
        return files.get(path);
    }

    public List<FileData> filterBySize(Long size) {
        List<FileData> filteredFiles = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : files.entrySet()) {
            for (FileData fileData : entry.getValue()) {
                if (fileData.getSize() <= size) {
                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedFiles = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : files.entrySet()) {
            sortedFiles.addAll(entry.getValue());
        }

        sortedFiles.sort(Comparator.comparingLong(FileData::getSize));
        return sortedFiles;
    }
}
