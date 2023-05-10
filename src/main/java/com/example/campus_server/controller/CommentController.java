package com.example.campus_server.controller;

import com.example.campus_server.entity.Comment;
import com.example.campus_server.service.CommentService;
import com.example.campus_server.service.RedisService;
import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "comment")
    public Result getComment(int comment_id) {
        Comment comment = commentService.getCommentById(comment_id);
        if (comment == null) {
            return ResultFactory.getErrorResult("评论不存在");
        } else {
            return ResultFactory.getSuccessResult("成功", comment);
        }
    }

    @RequestMapping(value = "postComment")
    public Result getCommentOfPost(int post_id) {
        List<Comment> comments = commentService.getCommentOfPost(post_id);
        return ResultFactory.getSuccessResult("成功", comments);
    }

    @RequestMapping(value = "newComment")
    public Result addComment(@RequestHeader Map<String, String> header, int post_id, String comment) {
        int uid = Integer.parseInt(header.get("uid"));
        commentService.addComment(uid, post_id, comment);
        return ResultFactory.getSuccessResult("成功");
    }

    @RequestMapping(value = "deleteComment")
    public Result deleteComment(@RequestHeader Map<String, String> header, int comment_id) {
        int uid = Integer.parseInt(header.get("uid"));
        char priv = redisService.getUserPrivilege(uid);
        if (priv == 'A') {
            commentService.deleteComment(comment_id);
            return ResultFactory.getSuccessResult("成功");
        } else {
            Comment comment = commentService.getCommentById(comment_id);
            if (comment.getAuthor_id() == uid) {
                commentService.deleteComment(comment_id);
                return ResultFactory.getSuccessResult("成功");
            } else {
                return ResultFactory.getErrorResult("无权限");
            }
        }
    }
}
