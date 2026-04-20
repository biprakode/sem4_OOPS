# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Search for palindrome and unique words in a text using class method and string method.

def _isPalindrome(word: str) -> bool:
    # single letter words are skipped on purpose
    if len(word) == 1:
        return False
    # even-length words cannot be palindromes in the way the assignment wants
    if len(word) % 2 == 0:
        return False
    # compare characters from both ends inward
    for idx, char in enumerate(word):
        if char != word[-idx - 1]:
            return False

    return True


class PalindromeFinder:
    def __init__(self, path: str):
        # remember the path and prep containers
        self.path = path
        self.palindromes = set()
        with open(path, 'r') as f:
            self.text = f.read()
            # flatten newlines into spaces so word splitting works
            self.text.replace('\n', ' ')
            print(self.text)
            # set auto-deduplicates for us
            self.unique_words = set(self.text.split())

    def findPalindromes(self):
        # scan every word, stash it if it reads the same both ways
        for words in self.text.split():
            if _isPalindrome(words):
                self.palindromes.add(words)

    def printPalindromes(self):
        print(self.palindromes)

    def printUniqueWords(self):
        print(self.unique_words)


if __name__ == '__main__':
    finder = PalindromeFinder('text.txt')
    finder.findPalindromes()
    finder.printPalindromes()
    finder.printUniqueWords()
