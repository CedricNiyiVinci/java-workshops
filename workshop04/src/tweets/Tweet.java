package tweets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tweet {

    private String text;
    private LocalDateTime publicationDate;
    private User author;
    private int retweets;

    public Tweet(String text, LocalDateTime publicationDate, User author, int retweets) {
        this.text = text;
        this.publicationDate = publicationDate;
        this.author = author;
        this.retweets = retweets;
    }

    public String getText() {
        return text + "\n";
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public User getAuthor() {
        return author;
    }

    public int getRetweets() {
        return retweets;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        return "\n\nTweet" +
                "\ntext='" + text + '\'' +
                "\npublicationDate : " + dateTimeFormatter1.format(publicationDate) +
                "\nuser=" + author +
                "\nretweets=" + retweets;
    }
}
