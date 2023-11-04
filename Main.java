import java.util.ArrayList;
import java.util.Scanner;

class MediaItem {
    private String title;
    private String genre;
    private double rating;

    public MediaItem(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nGenre: " + genre + "\nRating: " + rating;
    }
}

class MediaCatalog {
    private ArrayList<MediaItem> mediaItems = new ArrayList<>();

    public void addMediaItem(MediaItem mediaItem) {
        mediaItems.add(mediaItem);
    }

    public void displayMediaItems() {
        System.out.println("Media Catalog:");
        for (MediaItem item : mediaItems) {
            System.out.println(item.toString());
        }
    }

    public void updateMediaItem(String title, double newRating) {
        for (MediaItem item : mediaItems) {
            if (item.getTitle().equals(title)) {
                item.setRating(newRating);
                System.out.println("Rating updated successfully.");
                return;
            }
        }
        System.out.println("Media item not found.");
    }

    public void removeMediaItem(String title) {
        MediaItem itemToRemove = null;
        for (MediaItem item : mediaItems) {
            if (item.getTitle().equals(title)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            mediaItems.remove(itemToRemove);
            System.out.println("Media item removed successfully.");
        } else {
            System.out.println("Media item not found.");
        }
    }

    public void searchByTitle(String searchTerm) {
        System.out.println("Search Results:");
        for (MediaItem item : mediaItems) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(item.toString());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaCatalog catalog = new MediaCatalog();

        while (true) {
            System.out.println("Media Catalog Menu:");
            System.out.println("1. Add Media Item");
            System.out.println("2. Display Media Items");
            System.out.println("3. Update Media Item Rating");
            System.out.println("4. Remove Media Item");
            System.out.println("5. Search by Title");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    MediaItem newItem = new MediaItem(title, genre, rating);
                    catalog.addMediaItem(newItem);
                    System.out.println("Media item added.");
                    break;

                case 2:
                    catalog.displayMediaItems();
                    break;

                case 3:
                    System.out.print("Enter title of the media item to update: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    catalog.updateMediaItem(updateTitle, newRating);
                    break;

                case 4:
                    System.out.print("Enter title of the media item to remove: ");
                    String removeTitle = scanner.nextLine();
                    catalog.removeMediaItem(removeTitle);
                    break;

                case 5:
                    System.out.print("Enter a search term (title): ");
                    String searchTerm = scanner.nextLine();
                    catalog.searchByTitle(searchTerm);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
