create table test(
    id SERIAL PRIMARY KEY,
    question_type VARCHAR(30),
    question TEXT,
    possible_answers TEXT,
    correct_answer_indexes TEXT,
    correct_open_answers TEXT,
    contest_id int references contest(id)
    );
    
