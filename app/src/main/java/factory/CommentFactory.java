package factory;

import com.example.myapplication.Comment;

public class CommentFactory {

    public static Comment createComment(int reviewId, int userId, int bookId, String comment) {
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("Comment cannot be empty.");
        }

        return new Comment(reviewId, userId, bookId, comment); // Use the current date as datePosted
    }
}
