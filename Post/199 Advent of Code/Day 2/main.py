# PART 1 -----------------------------------------------------------------

# path: Post/199 Advent of Code/Day 2/input.txt
# Rock: A X
# Paper: B Y
# Scissor: C Z

# Points: 1 Rock, 2 Paper, 3 Scissors, 0 Lose, 3 Draw, 6 Win

# Task: calculate how many point the strategy guide (input) would give you


# Dictionary for the points
point_values = {"A": 1, "X": 1, "B": 2, "Y": 2,
                "C": 3, "Z": 3, "W": 6, "D": 3, "L": 0}

# open the matches and split into single lists
with open("Post/199 Advent of Code/Day 2/input.txt", "r") as file:
    match_list = []
    for line in file:
        line_list = line.split(" ")
        for i in range(len(line_list)):
            line_list[i] = line_list[i].strip()
        match_list.append(line_list)


# add the correct point for each match outcome

def calc_score(matches):
    outcomes = {"A X": 4, "A Y": 8, "A Z": 3, "B X": 1,
                "B Y": 5, "B Z": 9, "C X": 7, "C Y": 2, "C Z": 6}
    score = 0
    for game in matches:
        score += outcomes[" ".join(game)]

    return score


total_score = calc_score(match_list)

# show the total
print(f"Score with first approach: {total_score}")

# PART 2 -----------------------------------------------------------------

# X: lose
# Y: draw
# Z: win


def convert_outcome(games):
    new_list = []
    conversions = {"A X": ["A", "Z"], "A Y": ["A", "X"], "A Z": ["A", "Y"], "B X": ["B", "X"],
                   "B Y": ["B", "Y"], "B Z": ["B", "Z"], "C X": ["C", "Y"], "C Y": ["C", "Z"], "C Z": ["C", "X"]}
    for game in games:
        new_list.append(conversions[" ".join(game)])

    return new_list


match_list_converted = convert_outcome(match_list)
total_score_converted = calc_score(match_list_converted)

print(f"Score with second approach: {total_score_converted}")

# test that they converted correctly
# print(match_list[:10])
# print(match_list_converted[:10])
