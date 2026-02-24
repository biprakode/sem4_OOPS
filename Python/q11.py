def _isPalindrome(word:str) -> bool:
    if len(word)==1:
        return False
    if len(word)%2 == 0:
        return False
    for idx,char in enumerate(word):
        if char != word[-idx-1]:
            return False

    return True


class PalindromeFinder:
    def __init__(self, path:str):
        self.path = path
        self.palindromes = set()
        with open(path, 'r') as f:
            self.text = f.read()
            self.text.replace('\n',' ')
            print(self.text)
            self.unique_words = set(self.text.split())

    def findPalindromes(self):
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