package com.example.masterdetaillnterfacedesign.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();



    static {
        // Add some sample items.

            addItem(new PlaceholderItem("1", "Apple", "Apple.jpn"));
        addItem(new PlaceholderItem("2", "Fresas", "Fresa.jpn"));
        addItem(new PlaceholderItem("3", "Banana", "Banana.jpn"));
        addItem(new PlaceholderItem("4", "Uvas", "Uvas.jpn"));
        }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String fruitName;
        public final String fruitImage;

        public PlaceholderItem(String id, String fruitName, String fruitImage) {
            this.id = id;
            this.fruitName = fruitName;
            this.fruitImage = fruitImage;
        }

        @Override
        public String toString() {
            return fruitName;
        }
    }
}