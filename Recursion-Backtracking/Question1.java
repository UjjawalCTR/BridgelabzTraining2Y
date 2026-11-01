import java.util.ArrayList;
import java.util.List;

public class Question1 {
    abstract static class Item {
        String name;
        Item(String name) { this.name = name; }
        abstract long totalSize();
    }

    static class FileItem extends Item {
        long sizeKB;
        FileItem(String name, long sizeKB) {
            super(name);
            this.sizeKB = sizeKB;
        }
        @Override long totalSize() { return sizeKB; }
    }

    static class Directory extends Item {
        List<Item> children = new ArrayList<>();
        Directory(String name) { super(name); }
        void add(Item item) { children.add(item); }

        @Override long totalSize() {
            long total = 0;
            for (Item child : children) {
                total += child.totalSize();
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Directory project = new Directory("project");
        Directory src = new Directory("src");
        src.add(new FileItem("main.java", 100));
        src.add(new FileItem("utils.java", 50));

        Directory docs = new Directory("docs");
        docs.add(new FileItem("readme.txt", 10));
        Directory guides = new Directory("guides");
        guides.add(new FileItem("setup.pdf", 200));
        docs.add(guides);

        project.add(src);
        project.add(docs);
        project.add(new FileItem("config.xml", 20));

        System.out.println("Total size = " + project.totalSize() + " KB");
    }
}