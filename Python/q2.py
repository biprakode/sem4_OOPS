import random

coupons = {}
days = ["monday" , "tuesday" , "wednesday" , "thursday" , "friday" , "saturday" , "sunday"]

def fill_coupons(cpns) -> None:
    for day in days:
        disc = random.randint(1, 20)
        cpns[day] = f"{day[:3].upper()}{disc}"


def apply_coupons(day:str , coupon_code , price:float) -> int:
    day = day.strip().lower()
    if(cou)
    if day in coupons.keys():
        return price * (1 - int(coupons[day][-2:])/100)
    else:
        print("Invalid Coupon")
        return -1


fill_coupons(coupons)
print("discounts = " , coupons)
for i in range(1000):
    random_day = int(random.random() * len(days))
    disc = int(random.random() * 20)
    apply_coupons(days[random_day], f"{days[random_day][:3].upper()}{disc}" , 1000 )
