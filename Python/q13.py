import json
from collections import Counter

class RepetitiveString:
    def __init__(self , text:str):
        text = text.replace('\n',' ')
        self.text = text

    def __len__(self):
        self.words = self.text.split()
        self.unique = set(self.words)
        if len(self.unique) != len(self.words):
            return len(self.words) - len(self.unique)
        else:
            return len(self.text)

    def most_common(self) -> dict[int , str]:
        word_freqs = Counter(self.words)
        print(json.dumps(word_freqs, indent=4))
        print("Most common word - " , max(word_freqs, key=word_freqs.get))


if __name__ == "__main__":
    # Sample text with intentional repetitions
    sample_text = """
    coding is fun and coding is life
    life is short so coding is better
    """

    # Initialize the class
    rs = RepetitiveString(sample_text)

    try:
        len_rs = len(rs)
        print(f"Repetition Score/Length: {len_rs}")
    except ValueError:
        print("Length's fucked")


    print("\n--- Frequency Report ---")
    rs.most_common()