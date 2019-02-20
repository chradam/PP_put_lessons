import sqlalchemy as db
from sqlalchemy import create_engine, MetaData, Column, Integer, String, Table, ForeignKey, join
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship, column_property, sessionmaker, backref

Base = declarative_base()


# One User To Many Emails (bidirectional)

class Email(Base):
    __tablename__ = 'email'
    id = Column(Integer, primary_key=True, autoincrement=True)
    email = Column(String)
    user_id = Column(Integer, ForeignKey('user.id'))
    user = relationship("User", back_populates="emails")

    def __repr__(self):
        return "<('%s')>" % (
            self.email
        )


# One User To Many Phones (bidirectional)


class Phone(Base):
    __tablename__ = 'phone'
    id = Column(Integer, primary_key=True, autoincrement=True)
    phone = Column(String(9), unique=True)
    user_id = Column(Integer, ForeignKey('user.id'))
    user = relationship("User", back_populates="phones")

    def __repr__(self):
        return "<('%s')>" % (
            self.phone
        )

# One User To One Addresses (bidirectional)


class Address(Base):
    __tablename__ = 'address'
    id = Column(Integer, primary_key=True, autoincrement=True)
    street = Column(String)
    city = Column(String)
    post_code = Column(String(6))
    user_id = Column(Integer, ForeignKey('user.id'))
    user = relationship("User", back_populates="address")

    def __repr__(self):
        return "<(street='%s', city='%s', post code='%s')>" % (
            self.street,
            self.city,
            self.post_code
        )


# Many Users To Many Persons

association_table = Table('association', Base.metadata,
    Column('user_id', Integer, ForeignKey('user.id')),
    Column('person_id', Integer, ForeignKey('person.id'))
)


class Person(Base):
    __tablename__ = 'person'
    id = Column(Integer, primary_key=True, autoincrement=True)
    name = Column(String)
    fullname = Column(String)

    def __repr__(self):
        return "<('%s', '%s')>" % (
            self.name,
            self.fullname
        )

# One User To ...


class User(Base):
    __tablename__ = 'user'

    id = Column(Integer, primary_key=True, autoincrement=True)
    name = Column(String)
    fullname = Column(String)
    address = relationship("Address", uselist=False, back_populates="user")
    emails = relationship("Email", back_populates="user")
    phones = relationship("Phone", back_populates="user")
    persons = relationship("Person", secondary=association_table)

    def __init__(self, name, fullname):
        self.name = name
        self.fullname = fullname

    def __repr__(self):
        return "\n<User(name='%s', fullname='%s'\naddress='%s'\nemails='%s'\nphones='%s'\npersons='%s')>" % (
            self.name,
            self.fullname,
            self.address,
            self.emails,
            self.phones,
            self.persons
        )

def add():
    a1 = Address(street="Poziomkowa", city="Poznań", post_code="62-133")
    e1 = Email(email="adamch08@gmail.com")
    e2 = Email(email="achrzanowski@gmail.com")
    ph1 = Phone(phone="781034339")
    ph2 = Phone(phone="781031443")
    p1 = Person(name="Kalina", fullname="Jędrzejewska")
    p2 = Person(name="Artur", fullname="Marmurowy")

    u1 = User("Adam", "Chrzanowski")
    u2 = User("Jakub", "Chrzanowski")

    u1.address = a1
    u1.emails = [e1, e2]
    u1.phones = [ph1, ph2]
    u1.persons = [p1, p2]

    u2.persons = [p1, p2]

    session = Session()

    session.add(u1)
    session.add(u2)
    session.commit()

    users = session.query(User).all()

    for user in users:
        print(user)

    session.close()

if __name__ == "__main__":
    engine = create_engine("sqlite:///users.db")
    Base.metadata.create_all(bind=engine)
    Session = sessionmaker(bind=engine)

    # add()
    session = Session()
    query = session.query(User).\
            filter(User.name.like('%adam')).\
            order_by(User.id)

    for instance in query:
        print(instance)

    session.close()