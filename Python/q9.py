for index , char in enumerate(range(ord('1') , 255)):
    if(char >= ord('a') and char <= ord('z')):
        print((index , chr(char)))
