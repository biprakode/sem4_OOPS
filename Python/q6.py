import re
users = [
    ("bips" , "biprarshib@gmail.com" , 18),
    ("bips2" , "biprarshib2@gmail.com" , 15),
    ("bips3" , "biprarshib3@gmail.com" , 16),
    ("bips4" , "biprarshib4@gmail.com" , 17),
    ("bips5" , "biprarshib5@gmail.com" , 19),
    ("bips6" , "biprarshib6gmail.com" , 20)
]
class DuplicateUsername(Exception):
    pass

class FuckedUpAge(Exception):
    pass

class ProbablyAMinorrrr(Exception):
    pass

class BadEmail(Exception):
    pass

epstien = []
def DOJ_censor(username:str) -> str:
    return ''.join("█" * len(username))

def insert_user(user : tuple , user_dict) -> None:
    pattern = r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
    if(user_dict.get(user[0])):
        raise DuplicateUsername("already here")
    elif(user[2]<0):
        raise FuckedUpAge("are you for real")
    elif(user[2] <= 16):
        epstien.append(DOJ_censor(user[0]))
        raise ProbablyAMinorrrr("welcome to island")
    elif(not(re.match(pattern , user[1]))):
        raise BadEmail("Bad email")
    user_dict[user[0]] = user[1]

user_dict = {}

for user in users:
    try:
        insert_user(user , user_dict)
    except (DuplicateUsername , FuckedUpAge , ProbablyAMinorrrr , BadEmail) as e:
        print(user)
        print("Error - " , e)

print(epstien)