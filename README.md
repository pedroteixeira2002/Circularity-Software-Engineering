# Circularity — Software Engineering

A comprehensive Software Engineering project demonstrating modern development practices including Gradle build automation, CI/CD pipelines, agile Scrum methodology, and JUnit testing. This repository serves as both a learning platform and a practical example of collaborative software development in a real-world context.

[![Java](https://img.shields.io/badge/Java-100%25-orange.svg)](https://www.java.com/)
[![Gradle](https://img.shields.io/badge/Build-Gradle-brightgreen.svg)](https://gradle.org/)
[![JUnit](https://img.shields.io/badge/Testing-JUnit-red.svg)](https://junit.org/)

---

## Table of Contents

- [About](#about)
- [Key Features](#key-features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Building the Project](#building-the-project)
- [Running Tests](#running-tests)
- [CI/CD Pipeline](#cicd-pipeline)
- [Development Workflow](#development-workflow)
- [Scrum Methodology](#scrum-methodology)
- [Contributing](#contributing)
- [Wiki](#wiki)
- [License](#license)
- [Contact](#contact)

---

## About

The **Circularity — Software Engineering** project is designed to teach and demonstrate professional software engineering practices through hands-on development. The project emphasizes:

- **Gradle** for dependency management and build automation
- **CI/CD pipelines** for continuous integration and deployment
- **Scrum methodology** for agile project management
- **JUnit testing** for quality assurance and test-driven development
- **Version control** best practices with Git and GitHub
- **Collaborative development** in a team environment

This repository prepares students and developers for real-world challenges in professional software development by combining technical skills with agile practices and automated quality assurance.

## Key Features

✅ **Build Automation** — Gradle build system with dependency management  
✅ **Automated Testing** — Comprehensive JUnit test suite with CI integration  
✅ **CI/CD Integration** — Automated build, test, and deployment pipelines  
✅ **Agile Practices** — Scrum methodology with sprint planning and iterations  
✅ **Documentation** — Detailed project wiki and inline code documentation  
✅ **Quality Assurance** — Automated testing ensures code quality and reliability  

## Technologies

- **Language**: Java
- **Build Tool**: Gradle
- **Testing Framework**: JUnit 5
- **Version Control**: Git / GitHub
- **Methodology**: Scrum (Agile)
- **CI/CD**: GitHub Actions (or specify your CI/CD platform)

## Project Structure

```
Circularity-Software-Engineering/
├── src/
│   ├── main/
│   │   └── java/              # Application source code
│   │       └── com/
│   │           └── circularity/
│   └── test/
│       └── java/              # JUnit test cases
│           └── com/
│               └── circularity/
├── build.gradle               # Gradle build configuration
├── settings.gradle            # Gradle settings
├── gradlew                    # Gradle wrapper script (Unix)
├── gradlew.bat                # Gradle wrapper script (Windows)
├── .github/
│   └── workflows/             # CI/CD pipeline definitions
├── docs/                      # Additional documentation
├── README.md                  # This file
└── LICENSE                    # Project license
```

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)** 11 or higher
  - Check version: `java -version`
  - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **Git** for version control
  - Check version: `git --version`
  - Download: [Git](https://git-scm.com/downloads)
- **Gradle** (optional, project includes Gradle Wrapper)
  - Check version: `gradle --version`

### Installation

1. **Clone the repository**:

```bash
git clone https://github.com/pedroteixeira2002/Circularity-Software-Engineering.git
cd Circularity-Software-Engineering
```

2. **Verify Java installation**:

```bash
java -version
```

Expected output should show Java 11 or higher.

### Building the Project

The project uses **Gradle Wrapper**, so you don't need to install Gradle separately.

**On Linux/macOS**:

```bash
./gradlew build
```

**On Windows**:

```cmd
gradlew.bat build
```

This command will:
- Compile the source code
- Run all tests
- Generate build artifacts in the `build/` directory

**Clean and rebuild**:

```bash
./gradlew clean build
```

## Running Tests

The project uses **JUnit 5** for automated testing.

**Run all tests**:

```bash
./gradlew test
```

**Run tests with detailed output**:

```bash
./gradlew test --info
```

**View test report**:

After running tests, open the HTML report:
```
build/reports/tests/test/index.html
```

**Run specific test class**:

```bash
./gradlew test --tests "com.circularity.YourTestClassName"
```

## CI/CD Pipeline

This project implements automated CI/CD pipelines that:

1. **Build** — Compile the code on every push and pull request
2. **Test** — Run the entire JUnit test suite automatically
3. **Quality Checks** — Enforce code quality standards
4. **Deploy** — (If applicable) Deploy artifacts to staging/production

The CI/CD configuration can be found in `.github/workflows/` (for GitHub Actions) or equivalent configuration files for your CI platform.

**CI Pipeline triggers**:
- Every push to `main` branch
- Every pull request
- Scheduled nightly builds (optional)

## Development Workflow

We follow a **Git Flow** branching strategy aligned with Scrum practices:

1. **Create a feature branch** from `main`:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Develop and commit** your changes:
   ```bash
   git add .
   git commit -m "Add: description of your change"
   ```

3. **Push your branch**:
   ```bash
   git push origin feature/your-feature-name
   ```

4. **Open a Pull Request** on GitHub:
   - Describe your changes
   - Link to related issues or user stories
   - Request code review from team members

5. **CI checks pass** and code review approved → Merge to `main`

### Commit Message Convention

Follow these conventions for clear commit history:

- `Add: new feature or functionality`
- `Fix: bug fix`
- `Update: changes to existing code`
- `Refactor: code restructuring without behavior change`
- `Test: adding or updating tests`
- `Docs: documentation changes`

## Scrum Methodology

This project follows **Scrum** agile methodology:

### Sprint Structure

- **Sprint Duration**: 2 weeks (adjust as needed)
- **Sprint Planning**: Define user stories and tasks for the sprint
- **Daily Standups**: Brief sync on progress, blockers, and plans
- **Sprint Review**: Demo completed work to stakeholders
- **Sprint Retrospective**: Reflect and improve processes

### Scrum Artifacts

- **Product Backlog**: All features and requirements (GitHub Issues)
- **Sprint Backlog**: Selected items for current sprint (GitHub Projects)
- **Increment**: Potentially shippable product at sprint end

### GitHub Integration

- **Issues**: User stories and tasks
- **Projects**: Sprint board with columns (To Do, In Progress, Review, Done)
- **Milestones**: Sprint goals and deadlines
- **Labels**: Priority, type, story points

Visit the [Project Board](https://github.com/pedroteixeira2002/Circularity-Software-Engineering/projects) to view current sprints.

## Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork the repository** and create your branch from `main`
2. **Follow the coding standards**:
   - Write clean, readable Java code
   - Follow Java naming conventions
   - Add JavaDoc comments for public methods and classes
3. **Write tests** for new functionality
4. **Ensure all tests pass** before submitting PR
5. **Update documentation** as needed
6. **Submit a Pull Request** with a clear description

### Code Review Process

- All PRs require at least one approval
- CI checks must pass
- Code must meet quality standards
- Tests must achieve adequate coverage

## Wiki

For detailed documentation, guides, and tutorials, visit the [Project Wiki](https://github.com/pedroteixeira2002/Circularity-Software-Engineering/wiki).

Wiki sections include:
- Architecture Overview
- Setup Guides
- Coding Standards
- Testing Strategy
- Sprint Planning Templates
- Troubleshooting

## License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

## Contact

**Maintainer**: [@pedroteixeira2002](https://github.com/pedroteixeira2002)

For questions, issues, or collaboration:
- Open an [Issue](https://github.com/pedroteixeira2002/Circularity-Software-Engineering/issues)
- Start a [Discussion](https://github.com/pedroteixeira2002/Circularity-Software-Engineering/discussions)
- Contact via GitHub

---

**Ready to contribute?** Check out the [open issues](https://github.com/pedroteixeira2002/Circularity-Software-Engineering/issues) and join the next sprint! 🚀
