package io.github.maciejbiela.designpatternsproject.integrationtests.entrypoints.rest;

public class Response {
    private final int status;
    private final String content;

    public Response(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
