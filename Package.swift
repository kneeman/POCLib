// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "POCLib",
    platforms: [.macOS(.v13)],
    dependencies: [
        .package(url: "https://github.com/kneeman/POCLib.git", branch: "main")
    ],
    targets: [
        if (isLocal)
            .binaryTarget(
                    name: "poc-lib",
                    path: ".poc-lib/build/XCFrameworks/poc_lib.xcframework"
            ) else
            .binaryTarget(
                name: "$name",
                url: "$url",
                checksum: "$checksum"
            )
        ]
    ]
)