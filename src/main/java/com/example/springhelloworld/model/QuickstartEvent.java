package com.example.springhelloworld.model;

// Simple DTO for JSON events from topic `quickstart-events`
public record QuickstartEvent(String id, String type, String payload) {
}

