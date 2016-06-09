package io.github.maciejbiela.designpatternsproject.integration.entrypoints.rest;

class Response {
    private final int status;
    private final String content;

    Response(int status, String content) {
        this.status = status;
        this.content = content;
    }

    int getStatus() {
        return status;
    }

    String getContent() {
        return content;
    }
}
