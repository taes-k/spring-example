package api.review.msa.component;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding(MessageProducer.WriteReviewSource.class)
public class MessageProducer {

    public interface WriteReviewSource {
        String writeReview = "write-review";

        @Output(writeReview)
        MessageChannel writeReview();
    }
}
