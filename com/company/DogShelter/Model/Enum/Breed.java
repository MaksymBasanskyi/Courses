package com.company.DogShelter.Model.Enum;

public enum Breed {
    AFFENPINSCHER("Affenpinscher"),
    AFGHAN_HOUND("Afghan Hound"),
    AFGHAN_SHEPHERD("Afghan Shepherd"),
    AIDI("Aidi"),
    AIREDALE_TERRIER("Airedale Terrier"),
    AKBASH("Akbash"),
    AKITA("Akita"),
    ALASKAN_HUSKY("Alaskan husky"),
    ALASKAN_KLEE_KAI("Alaskan Klee Kai"),
    ALASKAN_MALAMUTE("Alaskan Malamute"),
    ALAUNT("Alaunt"),
    ALOPEKIS("Alopekis"),
    ALPINE_DACHSBRACKE("Alpine Dachsbracke"),
    ALPINE_MASTIFF("Alpine Mastiff");

    private String text;

    Breed(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Breed getByText(String text) {
        Breed targetBreed = null;
        for (Breed breed: Breed.values()) {
            if (breed.getText().equals(text)) {
                targetBreed = breed;
            }
        }
        if (targetBreed == null) {
            throw new IllegalArgumentException(String.format("No constant with text %s found", text));
        }

        return targetBreed;
    }
}
