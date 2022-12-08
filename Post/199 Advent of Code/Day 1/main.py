# PART 1 ------------------------------------------------------

# empty list to store the file content
cal_values = []

with open("Post/199 Advent of Code/Day 1/input.txt", "r") as file:
    # read the file line by line and convert to int
    for line in file:
        try:
            cal_values.append(int(line))
        except:
            cal_values.append(" ")

# empty dictionary where calories will be paired with elf
cal_values_grouped = {}

# count how many elf there are
total_elfs = 1
for pos in cal_values:
    if pos == " ":
        total_elfs += 1

# initialize all the dictionary positions
for i in range(total_elfs):
    cal_values_grouped[i+1] = 0

# add the values of each elf to their dictionary position. Jump to next when a whitespace is encountered
group_counter = 1
for value in cal_values:
    if value == " ":
        group_counter += 1
    else:
        cal_values_grouped[group_counter] += value

# show highest value
print(f"Maximum calories: {max(cal_values_grouped.values())}")


# PART 2 ------------------------------------------------------

# order descending values
ordered_by_cal = sorted(cal_values_grouped.values(), reverse=True)

# get the first three and sum
total_first_three = sum(ordered_by_cal[0:3])

# show sum
print(f"The 3 elfs with the most calories carry together: {total_first_three}")
