# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a discount coupon code using dictionary in Python with different rate coupons
# for each day of the week.

import random

# master dictionary that maps each weekday to its coupon
coupons = {}
days = ["monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"]


def fill_coupons(cpns) -> None:
    # for every day pick a random discount and build a coupon code like MON12
    for day in days:
        disc = random.randint(1, 20)
        cpns[day] = f"{day[:3].upper()}{disc}"


def apply_coupons(day: str, coupon_code, price: float) -> int:
    # normalize the day the user typed so "Monday " still works
    day = day.strip().lower()
    if coupon_code in coupons:
        if day in coupons.keys():
            # last two digits of the coupon hold the discount percentage
            return price * (1 - int(coupons[day][-2:]) / 100)
        else:
            print("Invalid Coupon")
            return -1


# generate today's coupons and show the user what's on offer
fill_coupons(coupons)
print("discounts = ", coupons)

# stress test: run a bunch of random orders to make sure nothing blows up
for i in range(1000):
    random_day = int(random.random() * len(days))
    disc = int(random.random() * 20)
    apply_coupons(days[random_day], f"{days[random_day][:3].upper()}{disc}", 1000)
