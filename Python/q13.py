class RepetitiveString:
    def __init__(self , text:str):
        text = text.replace('\n',' ')
        self.text = text

    def __len__(self):
        self.words = self.text.split()
        self.unique = set(self.words)
        if len(self.unique) != len(self.words):
            return len(self.unique)
        else:
            return len(self.text)


        return len(self.unique)