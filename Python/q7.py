import os

def dfs_traverse(root):
    for root , dirs , files in os.walk(root):
        print("$ - " , root)
        for file in files:
            print("file - " , os.path.join(root , file)) 

dfs_traverse("/home")