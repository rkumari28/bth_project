package com.bth.sportworker.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sports")
public record Sport(@Id String id, String sportName, String country, int players, String type) {
}
