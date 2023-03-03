CREATE TABLE `classes` (
   `id` int(10) NOT NULL,
   `section` int(60) NOT NULL,
   `teacher` int(10) NOT NULL,
   `subject` int(10) NOT NULL,
   `time` varchar(30) NOT NULL
);

INSERT INTO `classes` (`id`, `section`, `teacher`, `subject`, `time`) VALUES
(1, 1, 1, 1, '8:00'), (2, 2, 2, 2, '10:00'), (3, 3, 2, 3, '13:00');

CREATE TABLE `students` (
    `id` int(10) NOT NULL,
    `firstName` varchar(60) NOT NULL,
    `lastName` varchar(60) NOT NULL,
    `classId` int(10) NOT NULL
);

INSERT INTO `students` (`id`, `first_name`, `last_name`, `class_id`) VALUES
    (1, 'Gozde', 'Aldikacti', 1),
    (2, 'Emre', 'Civan', 2),
    (4, 'Deniz', 'Nil', 1),
    (5, 'John', 'Potter', 3),
    (6, 'Lily', 'Berg', 2);

CREATE TABLE `subjects` (
    `id` int(10) NOT NULL,
    `name` varchar(60) NOT NULL
);

INSERT INTO `subjects` (`id`, `name`, `code`) VALUES
  (1, 'Math', 'MAT'),
  (2, 'English', 'ENG'),
  (3, 'Java', 'CS');

CREATE TABLE `teachers` (
    `id` int(10) NOT NULL,
    `firstName` varchar(60) NOT NULL,
    `lastName` varchar(60) NOT NULL
);

INSERT INTO `teachers` (`id`, `first_name`, `last_name`) VALUES
   (1, 'Cagdas', 'Birant'),
   (2, 'Melissa', 'Red'),
   (3, 'Ozge', 'Yalcin');


ALTER TABLE `classes`
    ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject`),
  ADD KEY `teacher_id` (`teacher`);

ALTER TABLE `students`
    ADD PRIMARY KEY (`id`),
  ADD KEY `class_id` (`class`);

ALTER TABLE `subjects`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `teachers`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `classes`
    MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `students`
    MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `subjects`
    MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `teachers`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `classes`
    ADD CONSTRAINT `subject_id` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`),
  ADD CONSTRAINT `teacher_id` FOREIGN KEY (`teacher`) REFERENCES `teachers` (`id`);

ALTER TABLE `students`
    ADD CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);
COMMIT;