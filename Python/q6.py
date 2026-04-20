# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a simple program which loops over a list of user data (tuples containing a username,
# email and age) and adds each user to a directory if the user is at least 16 years old.
# You do not need to store the age. Write a simple exception hierarchy which defines a
# different exception for each of these error conditions:
#   - the username is not unique
#   - the age is not a positive integer
#   - the user is under 16
#   - the email address is not valid (a simple check for a username, the @ symbol and a domain name is sufficient)
# Raise these exceptions in your program where appropriate. Whenever an exception occurs,
# your program should move onto the next set of data in the list. Print a different error
# message for each different kind of exception.

import re

# sample input records - username, email, age
users = [
    ("bips", "biprarshib@gmail.com", 18),
    ("bips2", "biprarshib2@gmail.com", 15),
    ("bips3", "biprarshib3@gmail.com", 16),
    ("bips4", "biprarshib4@gmail.com", 17),
    ("bips5", "biprarshib5@gmail.com", 19),
    ("bips6", "biprarshib6gmail.com", 20)
]


# each failure mode gets its own exception class so we can tell them apart
class DuplicateUsername(Exception):
    pass


class FuckedUpAge(Exception):
    pass


class ProbablyAMinorrrr(Exception):
    pass


class BadEmail(Exception):
    pass


# tracks users who were flagged as minors
epstien = []


def DOJ_censor(username: str) -> str:
    # hide the name with blocks so it can still be logged without leaking
    return ''.join("█" * len(username))


def insert_user(user: tuple, user_dict) -> None:
    # a simple email regex - user@domain.tld
    pattern = r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"

    # already in the dict? bail
    if (user_dict.get(user[0])):
        raise DuplicateUsername("already here")
    elif (user[2] < 0):
        raise FuckedUpAge("are you for real")
    elif (user[2] <= 16):
        # remember the minor before raising
        epstien.append(DOJ_censor(user[0]))
        raise ProbablyAMinorrrr("welcome to island")
    elif (not (re.match(pattern, user[1]))):
        raise BadEmail("Bad email")

    # passed every check, store the email under the username
    user_dict[user[0]] = user[1]


user_dict = {}

# loop over the records and keep going even if one record is bad
for user in users:
    try:
        insert_user(user, user_dict)
    except (DuplicateUsername, FuckedUpAge, ProbablyAMinorrrr, BadEmail) as e:
        print(user)
        print("Error - ", e)

print(epstien)
