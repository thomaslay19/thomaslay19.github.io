import turtle

def arc(radius, degrees):
  turn_angle = 1
  step_size = 2*3.1415926*radius/360
  for i in range(degrees):
    turtle.forward(step_size)
    turtle.right(turn_angle)
def other_arc(radius, degrees):
  turn_angle = 1
  step_size = 2*3.1415926*radius/360
  for i in range(degrees):
    turtle.forward(step_size)
    turtle.left(turn_angle)
def flower(size):
  for j in range(1,4):
    arc(size, 120)
    turtle.right(120)
  turtle.penup()
  turtle.right(90)
  turtle.forward(size)
  turtle.left(150)
  turtle.pendown()
  for j in range(1,4):
    arc(size, 120)
    turtle.right(120)
  turtle.penup()
  turtle.right(330)
  turtle.forward(size)
  turtle.right(100)
  turtle.pendown()
turtle.color('purple',)
flower(150)
