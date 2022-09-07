package com.posada.santiago.gamapostsandcomments.application.bus;



import com.google.gson.Gson;
import com.posada.santiago.gamapostsandcomments.application.bus.models.CommentModel;
import com.posada.santiago.gamapostsandcomments.application.bus.models.PostModel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Component
public class RabbitMqConsumer {

    public static final String PROXY_QUEUE_POST_CREATED = "events.proxy.post.created";
    public static final String PROXY_QUEUE_COMMENT_ADDED = "events.proxy.comment.added";
    public static final String GENERAL_QUEUE = "events.general";
    private final Gson gson = new Gson();
    @Bean
    public Queue postCreatedQueue(){
        return new Queue(PROXY_QUEUE_POST_CREATED);
    }

    @Bean
    public Queue commentAddedQueue(){
        return new Queue(PROXY_QUEUE_COMMENT_ADDED);
    }

    @RabbitListener(queues = PROXY_QUEUE_POST_CREATED)
    public void listenToPostQueue(String received){

        PostModel post = gson.fromJson(received , PostModel.class);
        System.out.println(post.toString());
    }

    @RabbitListener(queues = PROXY_QUEUE_COMMENT_ADDED)
    public void listenToCommentQueue(String received){

        CommentModel comment = gson.fromJson(received , CommentModel.class);
        System.out.println(comment.toString());

    }

}
