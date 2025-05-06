package com.buthdev.demo.dto;

import java.util.Set;

public record BookDTO (String name, Set<Long> categoryId, Long authorId) {
}
