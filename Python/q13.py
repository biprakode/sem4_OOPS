# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write an operator overloading for len which shows string length for any given string
# and return only length of repetitive words with the text if the text has some repetitive
# parts. Determine the most frequently occurring words using most_common. Count string
# length in 4 different ways.

import json
from collections import Counter


class RepetitiveString:
    def __init__(self, text: str):
        # normalise newlines into spaces so splitting works cleanly
        text = text.replace('\n', ' ')
        self.text = text

    def __len__(self):
        # split the text and figure out if any words repeat
        self.words = self.text.split()
        self.unique = set(self.words)
        # if there are repeats, return how many of them are duplicates
        if len(self.unique) != len(self.words):
            return len(self.words) - len(self.unique)
        # otherwise fall back to raw character count
        else:
            return len(self.text)

    def most_common(self) -> dict[int, str]:
        # Counter gives us frequency out of the box
        word_freqs = Counter(self.words)
        print(json.dumps(word_freqs, indent=4))
        # pull the single most common word
        print("Most common word - ", max(word_freqs, key=word_freqs.get))


if __name__ == "__main__":
    # sample text with intentional repetitions
    sample_text = """
    coding is fun and coding is life
    life is short so coding is better
    """

    # build the helper class around the text
    rs = RepetitiveString(sample_text)

    try:
        len_rs = len(rs)
        print(f"Repetition Score/Length: {len_rs}")
    except ValueError:
        print("Length's fucked")

    print("\n--- Frequency Report ---")
    rs.most_common()
