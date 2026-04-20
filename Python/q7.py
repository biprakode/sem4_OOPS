# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a function findfiles that recursively descends the directory tree for the specified
# directory and generates paths of all the files in the tree.

import os


def dfs_traverse(root):
    # os.walk already does the recursive descent for us
    for root, dirs, files in os.walk(root):
        print("$ - ", root)
        # print the full path for every file we see
        for file in files:
            print("file - ", os.path.join(root, file))


# kick it off on the Python assignment folder
dfs_traverse("/run/media/biprarshi/COMMON/files/JUlabs/sem4_OOPS/Python")
