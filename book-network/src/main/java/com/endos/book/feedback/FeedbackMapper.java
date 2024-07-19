package com.endos.book.feedback;

import com.endos.book.book.Book;

import java.util.Objects;

public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request) {

        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false) // Not required and has no impact :: just to satisfy lombok
                        .shareable(false) // Not required and has no impact :: just to satisfy lombok
                        .build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {

    return FeedbackResponse.builder()
            .note(feedback.getNote())
            .comment(feedback.getComment())
            .ownFeedback(Objects.equals(feedback.getCreatedBy(),id))
            .build();
    }
}
