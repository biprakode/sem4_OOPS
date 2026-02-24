for index , char in enumerate(range(255)):
    if char >= ord('a') and char <= ord('z'):
        print((index - ord('a'), chr(char)))
