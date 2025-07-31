package org.example.rabbitmqdemo.consumer;

import java.io.Serializable;

public class UserMessage implements Serializable {
    private String msgId;
    private String content;
    private boolean  flag;

    public UserMessage() {}
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "msgId='" + msgId + '\'' +
                ", content='" + content + '\'' +
                ", flag=" + flag +
                '}';
    }
}
