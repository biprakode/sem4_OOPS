import random

coupons = {}
days = ["monday" , "tuesday" , "wednesday" , "thursday" , "friday" , "saturday" , "sunday"]

def fill_coupons(cpns) -> None:
    for day in days:
        cpns[day] = random.randint(1, 20)


def apply_coupons(day:str , price:float) -> int:
    day = day.strip().lower()
    if day in coupons.keys():
        return price * (1 - coupons[day]/100)
    else:
        print("Invalid Coupon")
        return -1


fill_coupons(coupons)
print("discounts = " , coupons)
print(apply_coupons("Monday", 100))
print(apply_coupons("Tuesday", 100))
print(apply_coupons("Wednesday", 100))
print(apply_coupons("Friday", 100))
print(apply_coupons("Saturday", 100))
print(apply_coupons("Sunday", 100))
print(apply_coupons("Thursday", 100))
